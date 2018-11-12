import ammonite.ops._
import $file.Styles, Styles.MyStyles._
import $ivy.`com.lihaoyi::scalatags:0.6.2`, scalatags.Text.all._
def dataUri(filepath: Path) = {
  "data:image/png;base64," +
  java.util.Base64.getEncoder().encodeToString(
    read.bytes! filepath
  )
}

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
  img(height := 15, src := dataUri(pwd/'images/s))
}
def section(title: String, body: Frag) = tr(

  td(h2(paddingTop := 10, paddingBottom := 10, sectionHeading, title, marginRight := 20)),
  td(paddingTop := 10, paddingBottom := 10, body)
)
def talk(name: String, pairs: (String, String)*) = div(
  h3(roleText, name),
  ul(listBlock,
    for((loc, video) <- pairs)
    yield li(listItem, autolink(video), div(float.right, rightGreyText, loc))
  )
)


val blob = html(
  fontFamily := "Calibri, Candara, Segoe, 'Segoe UI', Optima, Arial, sans-serif",
  head(
    scalatags.Text.tags2.style(raw(cssReset)),
    scalatags.Text.tags2.style(raw(Styles.MyStyles.styleSheetText))
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
        row(h2(sectionHeading, "Databricks"), logo("Databricks.png"), div(rightGreyText, "San Francisc, CA")),
        titledBlock(
          "Software Engineer - Developer Tools", "Oct 2017 - Present",
          """
          Sped up all core developer workflows (compiling Scala code, running
          test services, testing spark images, configuring deployment
          infrastructure, etc.) by 5-10x, reducing minutes- to tens-of-minutes-long
          workflows to a few seconds
          """,
          """
          Implemented a 50x faster compiler and an IntelliJ IDE plugin for the
          Jsonnet configuration language
          """,
          """
          Developed a "Dev Box" service that provides on-demand, one-click
          remote development environments. Developers get a large, fast remote
          machine to work on, further doubling the speed of arbitrary workflows
          while minimizing costs by shutting down when not in use.
          """,
          """
          Run regular surveys to take the subjective pain
          points that Databricks engineers with their tooling have and quantify
          them, letting us prioritize work on improvements that would
          have the largest and broadest impact .
          """,
          """
          Introduced structured error logging as a development practice,
          allowing engineers to rapidly find and fix issues in development and
          production services pro-actively, without needing to wait for customer
          complaints to come in
          """,
          """
          Ran "show and tell" tech talks with both internal and external speakers,
          helping disseminate knowledge and best practices across the organization
          and stimulating discussion and collaborating on common problems and
          pain points
          """
        ),
        row(h2(sectionHeading, "Dropbox"), logo("Dropbox.png"), div(rightGreyText, "San Francisco, CA")),
        titledBlock(
          "Software Engineer, Developer Tools", "Mar 2015 - Oct 2016",

          """
          Built static analysis tools for in Python and Coffeescript, allowing
          fast refactoring. Rejects 50+ buggy diffs a week
          """,
          """
          Rolled out an improved development workflow, reducing
          edit-refresh latency by 3x for Python and Coffeescript
          """,
          """
          Led a team of 2-3 to destroy flaky tests; reduced
          the number of builds failing due to flaky tests from about 10% to 1%
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
          Set up selenium tests (> 300 CI machines) & got them
          adopted. Reduced bugs reaching production by 5-10 a week
          """,
          """
          Modularized our >100,000 lines of Coffeescript, moving from a 'cat
          em all' build system to Require.js modules
          """,
          """
          Built an auto-packager using machine learning to reduce
          the number of Javascript downloads by 200ish per page
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
            "real-world projects. Built the core foundation of Scala.js libraries such as ",
            autolink("https://github.com/scala-js/scala-js-dom"), ", ",
            autolink("https://lihaoyi.com/upickle"), ", ",
            autolink("https://www.github.com/lihaoyi/utest"), ", and ",
            autolink("https://lihaoyi.com/scalatags"), ", and ",
            "wrote the free, interactive e-book ", i(talkName, "Hands-on Scala.js"), " (",
            autolink("http://www.hands-on-scala-js.com"), ")"
          ),
        ),
        row(h2(sectionHeading, "Ammonite"), logo("Ammonite.png")),
        bulletList(
          p(para,
            "Implemented the Ammonite REPL (",
            autolink("https://ammonite.io"),
            """) an improved Scala REPL and Script runner with
            syntax highlighting, pretty-printed output, multi-line editing,
            and many other quality-of-life improvements
            """
          ),
          p(para,
            """
            Well known in the community and used in many Scala shops,
            from startups to large ones like Twitter and Verizon
            """
          )
        ),
        row(h2(sectionHeading, "FastParse"), logo("fastparse.png")),
          p(para,
            autolink("https://www.lihaoyi.com/fastparse"),
            """
            : the de-facto standard parsing library for easily parsing structured
            text in Scala; makes writing parsers trivial and safe, while running
            hundreds of times faster than the built-in Scala parsing library
            """
        ),
        row(h2(sectionHeading, "Google Summer of Code"), logo("GSOC.png")),
        titledBlock(
          "GSOC 2016", "",
          span(
            "Mentored ",
            a(
              "Abhishek Kumar",
              href := "https://github.com/lihaoyi/Ammonite/pulls?utf8=%E2%9C%93&q=is%3Apr%20author%3Acoderabhishek%20"),
            ", working on performance, usability and Windows-support for Ammonite's",
            " scripts"
          ),
          span(
            "Mentored ",
            a(
              "Vladimir Polushin",
              href := "https://github.com/lihaoyi/fastparse/pulls?utf8=%E2%9C%93&q=is%3Apr%20author%3Avovapolu%20"),
            ", who extended Fastparse's string-parsing to support ",
            " parsing binary and streaming input"
          )
        ),
        titledBlock(
          "GSOC 2015", "",
          span(
            "Mentored ",
            a(
              "Laszlo Mero",
              href := "https://github.com/lihaoyi/Ammonite/pulls?utf8=%E2%9C%93&q=%20is%3Apr%20author%3Alaci37%20"),
            ", who first implemented script-running support for the Ammonite REPL"
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
            "SQL"
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
            "Software Engineer Intern, API Team", "May 2012 - Aug 2012"
          )
        ),
        div(
          row(h2(sectionHeading, "Facebook"), logo("Facebook.jpg"), div(rightGreyText, "Palo Alto, CA")),
          titledBlock(
            "Software Engineer Intern, Messaging Team", "May 2011 - Aug 2011"
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
            "Jan 2008 - Nov 2009"
          )
        )
      )
    ),
    section(
      "Reference",
      col(
        div(
          row(h2(sectionHeading, "Talks"), logo("GoogleSlides.png")),

          talk(
            "Four Facets of Good Open-Source Libraries",
            "SF/BayArea/NY Scala Meetups, Apr 2016" -> "https://vimeo.com/215325495"
          ),
          talk(
            "Scala Scripting",
            "Scala Exchange, 8 Dec 2016" -> "https://vimeo.com/194959852",
            "Scala by the Bay, 10 Nov 2016" -> "https://vimeo.com/191328477"
          ),
          talk(
            "Isomorphic Web Developement without Javascript, with Scala.js!",
            "Forward! JS Web Summit, 10 Feb 2016" -> "https://vimeo.com/154932681"
          ),
          talk(
            "Shell-scripting in a Typed, OO Language",
            "New Object Oriented Languages, SPLASH 28 Oct 2015" -> "https://vimeo.com/143819744"
          ),
          talk(
            "Fast, Modern, OO Parser Combinators",
            "Parsing@SLE, SPLASH 24 Oct 2015" -> "https://vimeo.com/143572750"
          ),
          talk(
            "FastParse:  Fast, Modern Parser Combinators",
            "SF Scala Meetup 13 Oct 2015" -> "https://vimeo.com/142341803"
          ),talk(
            "Beyond Bash",
            "Scala by the Bay 12 Aug 2015" -> "https://www.youtube.com/watch?v=dP5tkmWAhjg"
          ),
          talk(
            "Why (You might like) Scala.js",
            "Scaladays 17 Mar 2015" -> "https://vimeo.com/122611959"
          ),
          talk(
            "Scala.js - Safety & Sanity in the wild west of the web",
            "PhillyETE 8 Mar 2015" -> "https://vimeo.com/124702603"
          ),
          talk(
            "Bootstrapping the Scala.js Ecosystem",
            "Scala Exchange 7 Dec 2014" -> "https://vimeo.com/113967983"
          ),
          talk(
            "Hands-On Scala.js",
            "Pacific-North-West Scala 14 Nov 2014" -> "https://vimeo.com/111978847"
          ),
          talk(
            "Cross-platform development with Scala.js",
            "Scala by the Bay 9 Aug 2014" -> "https://www.youtube.com/watch?v=Ksoi6AG9nbA"
          ),
          talk(
            "Fun Functional-Reactive Programming with Scala.Rx",
            "Scaladays 17 Jun 2014" -> "https://vimeo.com/98477272"
          ),
          talk(
            "Live-Coding Scala.js",
            "SF Scala Meetup 28 Feb 2014" -> "https://vimeo.com/87845442"
          ),
          talk(
            "Metascala: a tiny DIY JVM",
            "Scala Exchange 2 Dec 2013" -> "https://skillsmatter.com/skillscasts/4916-metascala-a-tiny-diy-jvm"
          )
        )
      )
    )
  )
)
rm(pwd/'target/"resume.html")
write.over(pwd/'target/"resume.html", blob.render)
