package com.ar.mikellbobadilla.app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class PaginatedResponse<T> {
    private List<T> content;
    private int pages;
    private int size;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrev;

    public PaginatedResponse(List<T> content, Page<?> page) {
        this.content = content;
        this.pages = page.getTotalPages();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.hasNext = page.hasNext();
        this.hasPrev = page.hasPrevious();
    }
}
