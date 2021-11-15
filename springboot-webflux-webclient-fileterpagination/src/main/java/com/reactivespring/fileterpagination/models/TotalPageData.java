package com.reactivespring.fileterpagination.models;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TotalPageData {
	private List<TransactionApiResponse> listTransectionApiResponse = null;
}
