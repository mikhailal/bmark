package com.mypackage;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

public class Bench{

@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)
public String java11_replace_different() {
        String var = "\"meow\n[[[\"\"\'[][]\"\"meow\n[[[[\"\"\'[][]\"\"meowffff{}[]{}[[]]][]";
        var.replace("\"", "\'").replace("\n", "").replace("[]", "{}");
        return var;
}

@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)
public String java11_replace_allsubstituted() {
        String var = "\"\"\n\n[][][][]\n[][]\"\"\"\"\n\n[][][][][][]\n\n\n[][][][]\n\n[][][]";
        var.replace("\"", "\'").replace("\n", "").replace("[]", "{}");
        return var;
}



@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)
public String java11_replaceall_different() {
        String var = "\"meow\n[[[\"\"\'[][]\"\"meow\n[[[[\"\"\'[][]\"\"meowffff{}[]{}[[]]][]";
        var.replaceAll("\"", "\'").replaceAll("\n", "").replaceAll("\\[\\]", "{}");
        return var;
}

@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)
public String java11_replaceall_allsubstituted() {
        String var = "\"\"\n\n[][][][]\n[][]\"\"\"\"\n\n[][][][][][]\n\n\n[][][][]\n\n[][][]";
        var.replaceAll("\"", "\'").replaceAll("\n", "").replaceAll("\\[\\]", "{}");
        return var;
}

@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)

public String java11_replacesbuilder_different() {
        String var = "\"meow\n[[[\"\"\'[][]\"\"meow\n[[[[\"\"\'[][]\"\"meowffff{}[]{}[[]]][]";
        return Workaround.replacebuilder(var);
}

@Benchmark
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@Fork(value = 1, warmups = 0)

public String java11_replacesbuilder_allsubstituted() {
        String var = "\"\"\n\n[][][][]\n[][]\"\"\"\"\n\n[][][][][][]\n\n\n[][][][]\n\n[][][]";
        return Workaround.replacebuilder(var);
}
}
