package org.zerock.w6.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Getter
@ToString
public class PageResponse<E> {

    private java.util.List<E> list;
    private int total;
    private PageRequest pageRequest;

    private int startPage; //시작
    private int endPage; //화면에서 마지막 번호
    private boolean prev, next;

    @Builder(builderMethodName = "with")
    public PageResponse(List<E> list, int total, PageRequest pageRequest) {
        this.list = list;
        this.total = total;
        this.pageRequest = pageRequest;

        this.endPage = (int) (Math.ceil(pageRequest.getPage() / 10.0)) * 10;

        this.startPage = this.endPage - 9;

        int realEnd = (int) (Math.ceil((total * 1.0) / pageRequest.getSize()));

        if (realEnd <= this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;

        this.next = this.endPage < realEnd;
    }
}
