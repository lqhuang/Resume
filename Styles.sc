import $ivy.`com.lihaoyi::scalatags:0.6.0`, scalatags.Text.all._, scalatags.stylesheet._

object MyStyles extends StyleSheet{
  val cssReset =
    """
      |/* http://meyerweb.com/eric/tools/css/reset/
      |   v2.0 | 20110126
      |   License: none (public domain)
      |*/
      |
      |html, body, div, span, applet, object, iframe,
      |h1, h2, h3, h4, h5, h6, p, blockquote, pre,
      |a, abbr, acronym, address, big, cite, code,
      |del, dfn, em, img, ins, kbd, q, s, samp,
      |small, strike, strong, sub, sup, tt, var,
      |b, u, i, center,
      |dl, dt, dd, ol, ul, li,
      |fieldset, form, label, legend,
      |table, caption, tbody, tfoot, thead, tr, th, td,
      |article, aside, canvas, details, embed,
      |figure, figcaption, footer, header, hgroup,
      |menu, nav, output, ruby, section, summary,
      |time, mark, audio, video {
      |	margin: 0;
      |	padding: 0;
      |	border: 0;
      |	font-size: 100%;
      |	font: inherit;
      |	vertical-align: baseline;
      |}
      |/* HTML5 display-role reset for older browsers */
      |article, aside, details, figcaption, figure,
      |footer, header, hgroup, menu, nav, section {
      |	display: block;
      |}
      |body {
      |	line-height: 1;
      |}
      |ol, ul {
      |	list-style: none;
      |}
      |blockquote, q {
      |	quotes: none;
      |}
      |blockquote:before, blockquote:after,
      |q:before, q:after {
      |	content: '';
      |	content: none;
      |}
      |table {
      |	border-collapse: collapse;
      |	border-spacing: 0;
      |}
    """.stripMargin
  
  def nameText = cls(
    fontSize := 24,
    color := "#008"
  )

  def roleText = cls(
    fontSize := 12,
    fontWeight.bold,
    fontStyle.italic
  )

  def greyText = cls(
    fontSize := 10,
    color := "#888"
  )
  def rightGreyText = cls(
    greyText.splice,
    textAlign.right,
    flexGrow := 1
  )

  def listBlock = cls(
    marginBottom := 10
  )
  def para = cls(
    fontSize := 12,
    textAlign.justify,
    marginTop := 4,
    marginBottom := 4
  )
  def listItem = cls(
    para.splice,
    listStyle := "disc"
  )

  def sectionHeading = cls(
    color := "#008",
    marginBottom := 5,
    marginRight := 5
  )

  def talkName = cls(
    fontStyle.italic
  )
}

