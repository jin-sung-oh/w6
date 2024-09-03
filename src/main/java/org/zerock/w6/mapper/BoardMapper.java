package org.zerock.w6.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.zerock.w6.vo.BoardVO;
import org.zerock.w6.vo.PageRequest;

import java.util.Optional;

public interface BoardMapper {
    java.util.List<BoardVO> list(PageRequest pageRequest);

    int count(PageRequest pageRequest);

    Long insert(BoardVO vo);

    int delete(Long bno);

    int update(BoardVO vo);

    Optional<BoardVO> select(Long bno);

    @Update("update tbl_board set replyCnt = replyCnt + #{amount} where bno = #{bno}")
    int updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);

}
