# Haoyi's Resume

To build, download the Ammonite executable as described in the documentation for Ammonite's Snapshot Builds:

- http://www.lihaoyi.com/Ammonite/master/#Ammonite-REPL

And run

```
./amm Resume.sc
```

That should generate the output as a single file, with the images in-linedas base64, in `target/resume.html`

The documentation linked above also contains explanations for what the various magic imports mean:

- [import $file](http://www.lihaoyi.com/Ammonite/master/#import$file)
- [import $ivy](http://www.lihaoyi.com/Ammonite/master/#import$ivy)

The code comprises two files, `Resume.sc` which imports `Styles.sc`, using these magic imports:

```scala
import ammonite.ops._
import $file.Styles, Styles.MyStyles._ // import the `Styles` file, then everything from `Styles.MyStyles`
// import the scalatags artifact, then everything from `scalatags.Text.all._`. 
// width/height are imported specifically to avoid ambiguous imports from name collisions
import $ivy.`com.lihaoyi::scalatags:0.6.0`, scalatags.Text.all.{width, height, _}
```

These are features new to the Ammonite REPL, available in the Snapshot Build (which is stable and published to maven central etc.) and will be rolled out in a stable release in a week or two.

This repo was converted to Ammonite's Scripts from an SBT project, over the last two commits 

- https://github.com/lihaoyi/Resume/commit/9bced4fe7f1d8ccf083250bc5583b7609952dba3
- https://github.com/lihaoyi/Resume/commit/9e04a72a130293914fdc73bf97852f8cd8a5ccd2
