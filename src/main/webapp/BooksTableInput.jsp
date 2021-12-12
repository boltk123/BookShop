<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/booksTableInput.css">
    <title>Title</title>
</head>
<body>
<div id="container">
    <div class="upload-form">
        <h1 class="title">Upload Book</h1>
        <form method="post" action="FileUpload" enctype="multipart/form-data">
            <div class="col-left">
                <div class="input-field">
                    <label class="input-label" for="">Book ID</label>
                    <input type="text" name="book_id" value="${book.book_id}" required>
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Title</label>
                    <input type="text" name="title" value="${book.title}" required>
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Total Page</label>
                    <input required type="text" name="total_pages" value="${book.total_pages}">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Initial Rating</label>
                    <input required type="text" name="rating" value="${book.rating}" required>
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Author</label>
                    <input required type="text" name="author" value="${book.author}"required>
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book's genre</label>
                    <input required type="text" name="genre" value="${book.genre}">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Price ($)</label>
                    <input required type="text" name="cost" min="1" value="${book.cost}">
                </div>
            </div>
            <div class="col-right">
                <div class="description">
                    <label class="input-label" for="">Book Description</label>
                    <!-- <input type="text" name="description"> -->
                    <textarea name="description" cols="40" rows="2" >${book.description}</textarea>
                </div>
                <div class="input-images">
                    <div class="input-image">
                        <label class="input-label" for="">Book Cover</label>
                        <input type="file" name="book_cover" id="">
                    </div>
                    <div class="input-image">
                        <label class="input-label" for="">Book PDF File</label>
                        <input type="file" name="book_pdf" id="file">
                    </div>
                </div>
            </div>

            <input type="submit" value="Upload" name="action" class="upload-btn">
            <input type="submit" value="Edit" name="action" class="edit-btn">
        </form>
    </div>
</div>
</body>
</html>