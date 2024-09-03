package org.zerock.w6.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    String getTime();

    void insert1(String str);

    void insert2(String str);
}
