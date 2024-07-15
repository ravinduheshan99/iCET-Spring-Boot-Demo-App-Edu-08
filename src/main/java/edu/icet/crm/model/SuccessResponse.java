package edu.icet.crm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessResponse {
    Customer data;
    String status;
}
