package org.report.client;

import java.util.List;
import org.report.service.Adapter;
import org.report.service.Mapper;
import org.report.service.Reader;
import org.report.service.Reporter;

public class ReportGenerator<T, R, L> {

    private final Reader<L> reader;
    private final Adapter<L, T> adapter;
    private final Mapper<T> mapper;
    private final Reporter<T, R> reporter;

    public ReportGenerator(Reader<L> reader, Adapter<L, T> adapter, Mapper<T> mapper, Reporter<T, R> reporter) {

        this.reader = reader;
        this.adapter = adapter;
        this.mapper = mapper;
        this.reporter = reporter;
    }

    public List<R> generateReport() {
        return reporter.reports(
            mapper.mapBy(
                adapter.adapt(
                    reader.read()
                )
            )
        );
    }
}