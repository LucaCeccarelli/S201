package fr.univ_amu.iut.dao.jdbc;

import fr.univ_amu.iut.dao.jdbc.rowmappers.RowMapper;

import java.sql.Connection;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ResultSetStreamer {
    public static <T> Stream<T> stream(final Connection connection,
                                       final String sql,
                                       final RowMapper<T> rowMapper) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(
                        new ResultSetIterator<>(connection, sql, rowMapper), 0), false);
    }
}
