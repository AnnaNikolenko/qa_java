package ru.praktikum_services.qa_scooter.pojo;

import java.util.Objects;

public class PageInfo {
    private Integer page;
    private Integer total;
    private Integer limit;

    public PageInfo(Integer page, Integer total, Integer limit) {
        this.page = page;
        this.total = total;
        this.limit = limit;
    }

    public PageInfo(){}

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", total=" + total +
                ", limit=" + limit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageInfo pageInfo = (PageInfo) o;
        return Objects.equals(page, pageInfo.page) && Objects.equals(total, pageInfo.total) && Objects.equals(limit, pageInfo.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, total, limit);
    }
}
