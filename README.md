# Haoyi's Resume

This is a small demonstration of how to use [Ammonite](https://github.com/lihaoyi/Ammonite)'s 
new [Scala Scripts](http://www.lihaoyi.com/Ammonite/master/#ScalaScripts), which are available
in the latest snapshot build of Ammonite.

To build, download the Ammonite executable as described in the documentation for Ammonite's Snapshot Builds:

- http://www.lihaoyi.com/Ammonite/master/#Ammonite-REPL

```
curl -L -o amm https://git.io/vKwA8 && chmod +x amm
```

And run

```
./amm Resume.sc
```

That should generate the output as a single file, with the images in-lined as base64, in 
`target/resume.html`. The first time you run it it'll be slow compiling things but after 
that it should be cached and relatively snappy (<1s).

The documentation linked above also contains explanations for what the various magic imports mean:

- [import $file](http://www.lihaoyi.com/Ammonite/master/#import$file)
- [import $ivy](http://www.lihaoyi.com/Ammonite/master/#import$ivy)

The code comprises two files, `Resume.sc` which imports `Styles.sc`, using these magic imports:

```scala
import ammonite.ops._ // This is a normal import; `ammonite.ops` comes bundled with Ammonite

import $file.Styles, Styles.MyStyles._ // import the `Styles` file, then everything from `Styles.MyStyles`

// import the scalatags artifact, then everything from `scalatags.Text.all._`. 
// width/height are imported specifically to avoid ambiguous imports from name collisions
import $ivy.`com.lihaoyi::scalatags:0.6.0`, scalatags.Text.all.{width, height, _}
```

These are features new to the Ammonite REPL, available in the Snapshot Build (which is stable and published to maven central etc.) and will be rolled out in a stable release in a week or two.

This repo was converted to Ammonite's Scripts from an SBT project, over the last two commits 

- https://github.com/lihaoyi/Resume/commit/9bced4fe7f1d8ccf083250bc5583b7609952dba3
- https://github.com/lihaoyi/Resume/commit/9e04a72a130293914fdc73bf97852f8cd8a5ccd2

The purpose of this new script-file runner is to allow you to write small 
re-usable Scala programs without the boilerplate hassle of setting up an SBT
project and putting everything in `src/main/scala/mypkg/`. Just write a `.sc`
file, import any other `.sc` files or ivy artifacts you want, and run it using
`./amm`.
