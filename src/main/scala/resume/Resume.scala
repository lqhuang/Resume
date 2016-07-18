package resume

import ammonite.ops._
import Styles._
import scalatags.Text.all._
object Resume{
  def dataUri(filepath: Path) = {
    "data:image/png;base64," +
    javax.xml.bind.DatatypeConverter.printBase64Binary(
      read.bytes! filepath
    )
  }
  def main(args: Array[String]) = {

    def autolink(url: String) = a(url.stripPrefix("https://").stripPrefix("http://"), href:=url)
    def row = div(display.flex, flexDirection := "row")
    def col = div(display.flex, flexDirection := "column")
    def titledBlock(title: String, loc: String, bullets: Frag*) = div(
      row(
        h3(roleText, title),
        div(rightGreyText, loc)
      ),
      bulletList(bullets:_*)
    )
    def bulletList(bullets: Frag*) = ul(
      listBlock,
      bullets.map(li(listItem, _))
    )
    def quickBullet(lhs: String, rhs: String) = tr(
      td(div(para, roleText, paddingRight := 5, lhs)),
      td(para, rhs)
    )
    def logo(s: String) = {
      img(height := 15, src := dataUri(cwd/'images/s))
    }
    def section(title: String, body: Frag) = tr(

      td(h2(paddingTop := 10, paddingBottom := 10, sectionHeading, title, marginRight := 20)),
      td(paddingTop := 10, paddingBottom := 10, body)
    )
    def talk(name: String, loc: String, video: String) = div(
      row(h3(roleText, name), div(rightGreyText, loc)),
      ul(listBlock, li(listItem, autolink(video)))
    )


    val blob = html(
      fontFamily := "Calibri, Candara, Segoe, 'Segoe UI', Optima, Arial, sans-serif",
      head(
        scalatags.Text.tags2.style(raw(cssReset)),
        scalatags.Text.tags2.style(raw(Styles.styleSheetText))
      ),
      body(
        width := 720,
        boxSizing.`border-box`,
        padding := 30,
        row(
          width := "100%",
            div(
              width := "50%",
              h1(nameText, "Li Haoyi")
            ),
            col(
              width := "50%",
              div(textAlign.right, greyText, "haoyi.sg@gmail.com"),
              div(
                textAlign.right,
                greyText,
                autolink("http://www.lihaoyi.com")
              ),
              div(
                textAlign.right,
                greyText,
                autolink("http://www.github.com/lihaoyi/")
              )
            )
          )
      ),
      hr,
      table(
        width := "100%",
        section(
          "Work",
          col(
            row(h2(sectionHeading, "Dropbox"), logo("Dropbox.png"), div(rightGreyText, "San Francisco, CA")),
            titledBlock(
              "Software Engineer, Developer Tools", "Mar 2015 - Present",

              """
              Built static analysis tools for in Python and Coffeescript, allowing
              fast refactoring without fear. Enforces correctness, file-layout conventions,
              and blocks code smells such as import cycles or dead code.
              Rejects 50+ diffs a week
              """,
              """
              Rolled out an improved development workflow, reducing
              edit-refresh latency by 3x for Python and Coffeescript
              """,
              """
              Led a team of 2-3 to destroy flaky tests in our CI system; via research,
              monitoring, and automatic quarantine, we reduced the number of builds
              failing due to flaky tests from about 10% to 1%
              """,
              """
              Helped manage our CI system comprising >3000 CI machines
              """,
              """
              Mentored an intern completing a successful project (test
              quarantine) in his 12 weeks here
              """
            ),
            titledBlock(
              "Software Engineer, Web Platform", "Mar 2014 - Mar 2015",
              """
              Set up selenium test infrastructure (> 300 CI machines), created a
              streamlined developer workflow, and got it adopted across engineering.
              Reduced the number of bugs reaching production by 5-10 a week
              """,
              """
              Modularized our >100,000 lines of Coffeescript, moving from a 'cat
              em all' build system to Require.js modules
              """,
              """
              Built an auto-packager using machine learning to reduce
              the number of separate Javascript downloads by 200ish per page, cutting
              international latency by several seconds.
              """
            ),
            titledBlock(
              "Software Engineer, Dropbox for Business", "Aug 2013 - Mar 2014",
              """
              Worked on two-account migration for www.dropbox.com, two-account
              pairing flow
              """,
              """
              Performance improvements for most common pages, including speeding up the
              home page by 6x
              """
            )
          )
        ),
        section(
          "Open Source",
          col(
            row(h2(sectionHeading, "Scala.js"), logo("ScalaJS.png")),
            bulletList(
              p(para,
                "Pioneered usage of Scala.js, demonstrating its effectiveness in writing ",
                "real-world projects through ", autolink("https://lihaoyi.github.io/scala-js-games"), " and ",
                autolink("https://lihaoyi.github.io/roll")
              ),
              p(para,
                """
                Pushed for usability improvements that made Scala.js actually
                usable (edit-refresh speed, debuggability, etc.)
                """
              ),
              p(para,
                "Built the core foundation of Scala.js compatible libraries, such as ",
                autolink("https://github.com/scala-js/scala-js-dom"), ", ",
                autolink("https://lihaoyi.github.io/upickle-pprint/upickle"), ", ",
                autolink("https://www.github.com/lihaoyi/utest"), ", and ",
                autolink("https://lihaoyi.github.io/scalatags"), ", making it ",
                "possible to do real work with Scala.js"
              ),
              p(para,
                "Did presentations such as ", i(talkName, "Live Coding Scala.js"), ", Scala.js' ",
                "debut talk at the SF Scala Meetup, ",
                "which has been watched over 5,000 times. My Scala.js-related videos ",
                "have had >20,000 views on all platforms. Full listing below."
              ),
              p(para,
                "Wrote the free, interactive e-book ", i(talkName, "Hands-on Scala.js"), " (",
                autolink("http://www.hands-on-scala-js.com"), ")"
              ),
              p(para,
                "Built the community from nothing to >1000 people in the Gitter ",
                "channel, usage by hundreds of companies including big names ",
                "like Twitter, and people giving talks about it at every Scala conference."
              )
            ),
            row(h2(sectionHeading, "Ammonite"), logo("Ammonite.png")),
            bulletList(
              p(para,
                "Implemented the Ammonite REPL (",
                autolink("https://lihaoyi.github.io/Ammonite"),
                """) an improved Scala REPL with
                syntax highlighting, pretty-printed output, multi-line editing,
                and many other quality-of-life improvements
                """
              ),
              p(para,
                "Effectively the equivalent of IPython REPL for the Scala"
              ),
              p(para,
                """
                Well known in the community and used in many Scala shops,
                from startups to large ones like Twitter and Verizon
                """
              ),
              p(para,
                """
                Was forked to be used as the REPL for "Dotty", a
                project by the core Scala team trying to define the
                future of Scala
                """
              )
            ),
            row(h2(sectionHeading, "Other Projects")),
            div(listBlock,
              p(para,
                """
                Built many libraries that are widely used in the Scala
                community, both on Scala.js and on Scala's traditional platform
                the JVM, including many which are best-in-class for whatever
                problem they are trying to solve.
                Examples include:
                """
              )
            ),
            bulletList(
              p(para,
                span(roleText, "Scalatags "),
                autolink("https://lihaoyi.github.io/scalatags"),
                ": convenient, safe, and blazing-fast HTML templating.  ",
                "The go-to standalone HTML generation library for Scala, ",
                "its API has inspired many downstream projects like ",
                autolink("https://github.com/japgolly/scalajs-react"), " and ",
                autolink("https://github.com/widok/widok")
              ),
              p(para,
                span(roleText, "Scala-Js-Dom "),
                autolink("https://github.com/scala-js/scala-js-dom"),
                ": statically-typed bindings for the entirety of the Javascript ",
                "DOM APIs. Necessary for basically any project using Scala.js"
              ),
              p(para,
                span(roleText, "FastParse "),
                autolink("https://lihaoyi.github.io/fastparse"),
                ": convenient, safe and blazing-fast parser-combinators. ",
                "Basically the same as the std-lib parser-combinators but ",
                "better in every way. Currently the go-to library for anyone ",
                "who wants to write a parser in Scala, and is being ",
                "considered for being included in the standard library"
              ),

              p(para,
                span(roleText, "uPickle "),
                autolink("https://lihaoyi.github.io/upickle-pprint"),
                ": convenient, safe, and pretty-fast JSON serialization"
              ),
              p(para,
                span(roleText, "uTest "),
                autolink("https://www.github.com/lihaoyi/utest"),
                ": a tiny, minimal test-framework without bells and whistles"
              ),
              p(para,
                span(roleText, "Fansi "),
                autolink("https://wwww.github.com/lihaoyi/fansi"),
                ": convenient, safe and fast terminal colored-string manipulation"
              ),
              p(para,
                span(roleText, "SourceCode "),
                autolink("https://www.github.com/lihaoyi/sourcecode"),
                ": automatically capturing source metadata for logging and debuggability"
              )
            ),
            div(listBlock,
              p(para,
                """
                In total my libraries are getting >90,000 downloads a month
                from the Maven Central package repository. See
                """,
                autolink("https://lihaoyi.github.io/"), " to find out more."
              )
            )
          )
        ),
        section(
          "Buzzwords",
          h3(roleText,
            bulletList(
              Seq(
                "Scala",
                "Python",
                "Coffeescript",
                "Javascript",
                "Java",
                "C#",
                "Bash",
                "Ruby",
                "SQL",
                "F#",
                "PHP"
              ).mkString(" - "),
              Seq(
                "React.js",
                "Flask",
                "PostgreSQL",
                "Selenium",
                "JVM Internals",
                "Amazon Web Services",
                "IntelliJ",
                "Ubuntu"
              ).mkString(" - "),
              Seq(
                "Static Analysis",
                "Compilers",
                "REPLs",
                "Parser Combinators",
                "Syntactic Macros",
                "FRP"
              ).mkString(" - "),
              Seq(
                "Web Dev",
                "Algorithms",
                "Performance",
                "3D Graphics",
                "3D Physics",
                "Control Systems",
                "Sandboxing"
              ).mkString(" - ")
            )
          )
        ),
        section(
          "Ancient History",
          col(
            div(
              row(
                h2(sectionHeading, "Massachusetts Institute of Technology"),
                // Override height to compensate for non-square image
                logo("MIT.png")(height := 12, paddingTop := 4),
                div(rightGreyText, "Cambridge, MA")
              ),
              titledBlock(
                "Undergraduate Computer Science, GPA 4.8/5.0", "Sep 2010 - Jun 2013"
              )
            ),
            div(
              row(h2(sectionHeading, "Dropbox"), logo("Dropbox.png"), div(rightGreyText, "San Francisco, CA")),
              titledBlock(
                "Software Engineer Intern, API Team", "May 2012 - Aug 2012",
                """
                Built, documented and launched infrastructure to allow API apps to upload
                large files to Dropbox
                """,
                """
                Wrote unit tests, improved documentation and set up continuous
                integration for the Dropbox client SDKs
                """
              )
            ),
            div(
              row(h2(sectionHeading, "Facebook"), logo("Facebook.jpg"), div(rightGreyText, "Palo Alto, CA")),
              titledBlock(
                "Software Engineer Intern, Messaging Team", "May 2011 - Aug 2011",
                "Built an extensible attachment framework for Facebook Messages."
              )
            ),
            div(
              row(
                h2(sectionHeading, "Singapore Armed Forces"),
                logo("SAF.png"),
                div(rightGreyText, "Singapore")
              ),
              titledBlock(
                "Lieutenant, Platoon Commander, 35th Battalion Singapore Combat Engineers",
                "Jan 2008 - Nov 2009",
                """
                Managed the platoon's discipline and wellbeing, and their
                proficiency at operating military bridges.
                """,
                "Took part in combined-arms field exercises"
              )
            )
          )
        ),
        section(
          "Reference",
          col(
            div(
              row(h2(sectionHeading, "Talks"), logo("GoogleSlides.png")),
              div(listBlock,
                p(para, """
                  Presentations I've given: at meetup groups,
                  industry conferences and academic workshops. Stay a while and listen!
                """)
              ),
              talk(
                "Isomorphic Web Developement without Javascript, with Scala.js!",
                "Forward! JS Web Summit, 10 Feb 2016",
                "https://vimeo.com/154932681"
              ),
              talk(
                "Shell-scripting in a Typed, OO Language",
                "New Object Oriented Languages, SPLASH 28 Oct 2015",
                "https://vimeo.com/143819744"
              ),
              talk(
                "Fast, Modern, OO Parser Combinators",
                "Parsing@SLE, SPLASH 24 Oct 2015",
                "https://vimeo.com/143572750"
              ),
              talk(
                "FastParse:  Fast, Modern Parser Combinators",
                "SF Scala Meetup 13 Oct 2015",
                "https://vimeo.com/142341803"
              ),talk(
                "Beyond Bash",
                "Scala by the Bay 12 Aug 2015",
                "https://www.youtube.com/watch?v=dP5tkmWAhjg"
              ),
              talk(
                "Why (You might like) Scala.js",
                "Scaladays 17 Mar 2015",
                "https://vimeo.com/122611959"
              ),
              talk(
                "Scala.js - Safety & Sanity in the wild west of the web",
                "PhillyETE 8 Mar 2015",
                "https://vimeo.com/124702603"
              ),
              talk(
                "Bootstrapping the Scala.js Ecosystem",
                "Scala Exchange 7 Dec 2014",
                "https://vimeo.com/113967983"
              ),
              talk(
                "Hands-On Scala.js",
                "Pacific-North-West Scala 14 Nov 2014",
                "https://vimeo.com/111978847"
              ),
              talk(
                "Cross-platform development with Scala.js",
                "Scala by the Bay 9 Aug 2014",
                "https://www.youtube.com/watch?v=Ksoi6AG9nbA"
              ),
              talk(
                "Fun Functional-Reactive Programming with Scala.Rx",
                "Scaladays 17 Jun 2014",
                "https://vimeo.com/98477272"
              ),
              talk(
                "Live-Coding Scala.js",
                "SF Scala Meetup 28 Feb 2014",
                "https://vimeo.com/87845442"
              ),
              talk(
                "Metascala: a tiny DIY JVM",
                "Scala Exchange 2 Dec 2013",
                "https://skillsmatter.com/skillscasts/4916-metascala-a-tiny-diy-jvm"
              )
            )
          )
        )
      )
    )
    write.over(cwd/'target/"resume.html", blob.render)
  }
}
