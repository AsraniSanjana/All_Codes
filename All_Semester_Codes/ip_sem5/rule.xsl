<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<!-- <html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> -->
<html>
<body>
<h3>stud db</h3>
<table border="1">
<tr bgcolor="blue">
<th>studentname</th>
<th>address</th>
<th>mobile</th>
<th>email</th>
</tr>

<xsl:for-each select="student/personal_details">
<tr>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="address"/></td>
<td><xsl:value-of select="mobile"/></td>
<td><xsl:value-of select="email"/></td>

</tr>
</xsl:for-each>


</table>
</body>
</html>


</xsl:template>
</xsl:stylesheet>