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
                    <input type="text" name="book_id">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Title</label>
                    <input type="text" name="title">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Total Page</label>
                    <input type="text" name="total_pages">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Initial Rating</label>
                    <input type="text" name="rating">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Author</label>
                    <input type="text" name="author">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book's genre</label>
                    <input type="text" name="genre">
                </div>
                <div class="input-field">
                    <label class="input-label" for="">Book Price ($)</label>
                    <input type="text" name="cost" min="1" step="any">
                </div>
            </div>
            <div class="col-right">
                <div class="description">
                    <label class="input-label" for="">Book Description</label>
                    <!-- <input type="text" name="description"> -->
                    <textarea name="description" cols="40" rows="2"></textarea>
                </div>
                <div class="input-images">
                    <div class="input-image">
                        <label class="input-label" for="">Book Cover</label>
                        <input type="file" name="book_cover" id="">
                    </div>
                    <div class="input-image">
                        <label class="input-label" for="">Book First Sample</label>
                        <input type="file" name="book_sample1" id="">
                    </div>
                    <div class="input-image">
                        <label class="input-label" for="">Book Second Sample</label>
                        <input type="file" name="book_sample2" id="">
                    </div>
                    <div class="input-image">
                        <label class="input-label" for="">Book Third Sample</label>
                        <input type="file" name="book_sample3" id="">
                    </div>
                </div>
            </div>

            <input type="submit" value="Upload" class="upload-btn">
        </form>
    </div>
</div>
</body>
</html>