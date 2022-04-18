package com.mendes.controller;

import com.mendes.model.dto.FootballSurveyDto;
import com.mendes.service.FootballSurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mendes
 */

@CrossOrigin
@RestController
@Api(value = "football-survey")
@RequestMapping("football-survey")
public class FootballSurveyController {

    private final FootballSurveyService footballSurveyService;

    public FootballSurveyController(FootballSurveyService footballSurveyService) {
        this.footballSurveyService = footballSurveyService;
    }

    @ApiOperation(value = "save")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("/save")
    public ResponseEntity<FootballSurveyDto> save(@RequestBody FootballSurveyDto footballSurveyDto) {
        FootballSurveyDto returnFootballSurveyDto = footballSurveyService.save(footballSurveyDto);
        try {
            return ResponseEntity.ok(returnFootballSurveyDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnFootballSurveyDto);
        }
    }

    @ApiOperation(value = "get by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FootballSurveyDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(footballSurveyService.getById(id));
    }

    @ApiOperation(value = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/list")
    public ResponseEntity<List<FootballSurveyDto>> list() {
        return ResponseEntity.ok(footballSurveyService.list());
    }

    @ApiOperation(value = "delete")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        footballSurveyService.delete(id);
    }

    @ApiOperation(value = "update")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping("/update")
    public ResponseEntity<FootballSurveyDto> update(@RequestBody FootballSurveyDto footballSurveyDto) {
        FootballSurveyDto returnFootballSurveyDto = footballSurveyService.update(footballSurveyDto);
        try {
            return ResponseEntity.ok(returnFootballSurveyDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnFootballSurveyDto);
        }
    }
}
