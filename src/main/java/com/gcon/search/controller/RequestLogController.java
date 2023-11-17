package com.gcon.search.controller;

import com.gcon.search.entity.Content;
import com.gcon.search.entity.LogDetail;
import com.gcon.search.request.LogRequest;
import com.gcon.search.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestLogController {
    @Autowired
    ILogService service;

    @PostMapping("/log")
    public ResponseEntity<String> incomingLog(@RequestBody LogRequest request) throws Exception {
        return new ResponseEntity<>(service.incomingLog(request), HttpStatus.OK);

    }
    @GetMapping("/get-log/{userId}")
    public ResponseEntity<List<LogDetail>> getLogDetail(@PathVariable Long userId) throws Exception {
        return new ResponseEntity<>(service.getLogDetail(userId), HttpStatus.OK);
    }
}
