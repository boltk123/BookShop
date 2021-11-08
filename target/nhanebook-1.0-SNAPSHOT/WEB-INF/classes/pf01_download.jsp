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

<h1 class="centered">Downloads</h1>

<h2 class="centered">Paddlefoot - The First CD</h2>
    
<table class="box">
<tr>
    <th><h2>Song title</h2></th>
    <th><h2>Audio Format</h2></th>
</tr>
<tr>
    <td><p>64 Corvair</p></td>
    <td class="centered"><a href="DownloadFileSupportServlet?filename=corvair.mp3&amp;directory=/sound/pf01/">MP3</a></td>
</tr>
<tr>
    <td><p>Whiskey Before Breakfast</p></td>
    <td class="centered"><a href="DownloadFileSupportServlet?filename=whiskey.mp3&amp;directory=/sound/pf01/">MP3</a></td>
</tr>
</table>

<p class="centered"><a href="?action=viewAlbums">View list of albums</a></p>

<p class="centered"><a href="?action=viewCookies">View all cookies</a></p>

</body>
</html>