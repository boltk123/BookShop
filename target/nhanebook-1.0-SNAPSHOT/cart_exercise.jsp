<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
</head>
<body class="backgr">
    
<h1 class="centered">CD list</h1>
<table class="box">
    <tr>
        <th><h2>Description</h2></th>
        <th class="right"><h2>Price</h2></th>
        <th>&nbsp;</th>
    </tr>
    <tr>
        <td><p>86 (the band) - True Life Songs and Pictures</p></td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="8601">
                <input class="" type="submit" value="Add To Cart">
            </form><!--<a href="cart?productCode=8601">Add To Cart</a>--></td>
    </tr>
    <tr>
        <td><p>Paddlefoot - The first CD</p></td>
        <td class="right">$12.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td><p>Paddlefoot - The second CD</p></td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf02">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td><p>Joe Rut - Genuine Wood Grained Finish</p></td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="jr01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
</table>
<br>
<form action="cart" method="post">
    <input type="hidden" name="action" value="seecart">
    <div class=centered><input class="button" type="submit"  value="See Cart"></div>
</form>
<form action="index.html">
    <div class=centered><input class="button" type="submit"  value="Back To Home Page"></div>
</form><br>
</body>
</html>