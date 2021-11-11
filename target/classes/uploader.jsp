<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h4>Upload file</h4>
    <form method="post" action="FileUpload" enctype="multipart/form-data">
        <input type="text" name="book_id" value="Input Book ID"/>
        <input type="file" name="file" multiple accept="image/*"/>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>