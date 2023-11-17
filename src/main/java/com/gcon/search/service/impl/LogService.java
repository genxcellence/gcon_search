package com.gcon.search.service.impl;

import com.gcon.search.entity.LogDetail;
import com.gcon.search.repository.LogDetailRepository;
import com.gcon.search.request.LogRequest;
import com.gcon.search.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class LogService implements ILogService {
    @Autowired
    LogDetailRepository logDetailRepository;
    @Override
    public String incomingLog(LogRequest request) throws Exception {
        Long userId = request.getUserId();
        String requestBody = request.getRequestBody();
        String methodType = request.getMethodType();
        Timestamp createTimestamp=Timestamp.from(Instant.now());
        String logMessage = String.format("Timestamp: %s - Received log for User ID: %d, Method Type: %s, Request Body: %s",
                createTimestamp.toString(), userId, methodType, requestBody);
        LogDetail logDetail=new LogDetail();
        logDetail.setLogMessage(logMessage);
        logDetail.setUserId(userId);
        logDetailRepository.save(logDetail);
        return logMessage;
    }

    @Override
    public List<LogDetail> getLogDetail(Long userId) throws Exception {
        return logDetailRepository.getLogsByUserId(userId);
    }
}
