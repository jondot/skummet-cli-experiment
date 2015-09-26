# Clojure for CLI

Tl;dr:

Using Clojure with [Skummet](http://clojure-android.info/skummet/) makes a reasonable startup times for a CLI app, in comparison
to Racket, a popular Scheme implementation.



## Background

Is it possible to get good startup time for shippable CLI tools with Clojure using what we have right now, and
not use nail/trampoline like solutions?


During a vivid session on freenode's #clojure, I've taken the vanilla [Skummet sample](https://github.com/alexander-yakushev/lein-skummet), 
and tried NOT to use it on Android, but on a plain command line scenario. 

Testing some real-life-ish use case - take a webpage and scrape it with `jsoup`, print out the result.

Hoping it would present a real life scenario for building tools with Clojure that would
run on the command line, and avoiding the now famously long Clojure startup time.

Following are the results of this run.

### Setting

I'm using 

* Java 8, lein 2.5.3
* MBP mid-2014, i7 2.2Ghz, SSD

### Running

Simply use `jar.sh`, and then run the result jar with:

```
$ java -jar ./target/lein-skummet-sample-0.0.1-SNAPSHOT-standalone.jar
```


### Timing

To time this sample, we need to kill it before going out to the network. The
presence of a CLI argument does that:

```
$ time java -jar ./target/lein-skummet-sample-0.0.1-SNAPSHOT-standalone.jar foobar
```

### Results

Skummet:

```
java -jar ./target/lein-skummet-sample-0.0.1-SNAPSHOT-standalone.jar foo  0.49s user 0.05s system 156% cpu 0.347 total
```

Racket:

```
racket foo.scm  0.21s user 0.05s system 97% cpu 0.264 total
```

So, in theory for a human, a < 100ms difference is just about borderline noticeable.


Is Clojure good for CLI tools now?





