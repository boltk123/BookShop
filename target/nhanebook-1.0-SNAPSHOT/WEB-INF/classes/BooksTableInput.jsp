<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h4>Upload file</h4>
    <form method="post" action="FileUpload" enctype="multipart/form-data">
        <p1>Input Book ID</p1>
        <input type="text" name="book_id"/><br>
        <p1>Input Book Title</p1>
        <input type="text" name="title"/><br>
        <p1>Input Book Total Page</p1>
        <input type="text" name="total_pages"/><br>
        <p1>Input Book Initial Rating</p1>
        <input type="text" name="rating"/><br>
        <p1>Input Book Book Author</p1>
        <input type="text" name="author"/><br>
        <p1>Input Book Book's genre</p1>
        <input type="text" name="genre"/><br>
        <p1>Input Book Price</p1>
        <input type="text" name="cost" min="1" step="any" /><p>$</p><br>
        <p1>Input Book Description</p1>
        <input type="text" name="description"/><br>
        <p1>Input Book Cover Picture</p1>
        <input type="file" name="book_cover" accept="image/*"/>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>