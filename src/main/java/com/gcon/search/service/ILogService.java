package com.gcon.search.service;

import com.gcon.search.entity.LogDetail;
import com.gcon.search.request.LogRequest;

import java.util.List;

public interface ILogService {
    String incomingLog(LogRequest request) throws Exception;

    List<LogDetail> getLogDetail(Long userId) throws Exception;
}
