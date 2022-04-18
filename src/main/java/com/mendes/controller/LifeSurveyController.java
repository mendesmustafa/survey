package com.mendes.controller;

import com.mendes.model.dto.LifeSurveyDto;
import com.mendes.service.LifeSurveyService;
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
@Api(value = "life-survey")
@RequestMapping("life-survey")
public class LifeSurveyController {

    private final LifeSurveyService lifeSurveyService;

    public LifeSurveyController(LifeSurveyService lifeSurveyService) {
        this.lifeSurveyService = lifeSurveyService;
    }

    @ApiOperation(value = "save")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("/save")
    public ResponseEntity<LifeSurveyDto> save(@RequestBody LifeSurveyDto lifeSurveyDto) {
        LifeSurveyDto returnLifeSurvey = lifeSurveyService.save(lifeSurveyDto);
        try {
            return ResponseEntity.ok(returnLifeSurvey);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnLifeSurvey);
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
    public ResponseEntity<LifeSurveyDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lifeSurveyService.getById(id));
    }

    @ApiOperation(value = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/list")
    public ResponseEntity<List<LifeSurveyDto>> list() {
        return ResponseEntity.ok(lifeSurveyService.list());
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
        lifeSurveyService.delete(id);
    }

    @ApiOperation(value = "update")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping("/update")
    public ResponseEntity<LifeSurveyDto> update(@RequestBody LifeSurveyDto lifeSurveyDto) {
        LifeSurveyDto returnLifeSurvey = lifeSurveyService.update(lifeSurveyDto);
        try {
            return ResponseEntity.ok(returnLifeSurvey);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(returnLifeSurvey);
        }
    }

}
