package com.soulchild.work.model;

import lombok.Data;

@Data
public class PageInfo {
    public Boolean is_end;
    public int pageable_count;
    public int total_count;
}
