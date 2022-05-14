package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.BookRankRespDto;

import java.util.List;

/**
 * 小说模块 服务类
 *
 * @author xiongxiaoyang
 * @date 2022/5/14
 */
public interface BookService {

    /**
     * 小说点击榜查询
     * */
    RestResp<List<BookRankRespDto>> listVisitRankBooks();

    /**
     * 小说新书榜查询
     * */
    RestResp<List<BookRankRespDto>> listNewestRankBooks();

    /**
     * 小说更新榜查询
     * */
    RestResp<List<BookRankRespDto>> listUpdateRankBooks();
}
