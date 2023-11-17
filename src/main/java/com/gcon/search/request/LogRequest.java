package com.gcon.search.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private Long userId;
    private String requestBody;
    private String methodType;
}
