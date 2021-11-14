<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="css/style.css"/>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
      <link>
    <title>Little Giants</title>
  </head>
  <body>
    <div class="navbar"> 
        <nav>
            <div class="logo">
                <h1><a href="index.jsp">Little Giants</a></h1>
            </div>
            <ul class="nav-links">
                <li><a href="#home">Home</a></li>
                <li><a href="#members">Members</a></li>
                <li><a href="#exercises">Exercises</a></li>
                <li><a href="homepage.jsp">Project</a></li>

            </ul>
            <div class="burger">
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </nav>
    </div>   
    <script src="app.js"></script>
    
    <!--Navigation bar ends-->

    <!--<section id="home">
        <div class="home_container">
            <div class="introduce">
                <h1>Welcome to our site</h1>
                <h1>Make yourself at home</h1>
            </div>
        </div>
    </section>-->
    <section id="home">
            <div class="home">
                <div class="home_content">
                    <p>
                        Wellcome to our
                    </p>
                    <h3>Little Giant's <br> Creative Studio</h3>
                </div>
            </div>
    </section>

    <!--Home ends-->

    <!--<section id="members">
        <div class="members_container">
            <div class="members">
                <div class="quang">
                    <h1>Nguyễn Quang</h1><br><img src="image/QuanVu.jpg"><br><h1>19110119</h1><br>
                    <button class="btn">Details</button>
                </div>
                <div class="nhan">
                    <h1>Bùi Đức Nhân</h1><br><img src="image/LuuBi.jpg"><br><h1>19110119</h1><br>
                    <button class="btn">Details</button>
                </div>
                <div class="luan">
                    <h1>Bùi Hữu Luận</h1><br><img src="image/TruongPhi.jpg"><br><h1>19110119</h1><br>
                    <button class="btn">Details</button>
                </div>

            </div>
        </div>
    </section>-->
    <section id="members">
    <div class="container">
        <h1 class="heading"><span>meet</span>Our Team</h1>

        <div class="profiles">
            <div class="profile">
                <img src="image/QuanVu.jpg" class="profile-img">

                <h3 class="user-name">Nguyễn Quang</h3>
                <h5>Frontend Coder</h5>
                <p>Smart, Creative, Enthusiastic</p>
            </div>
            <div class="profile">
                <img src="image/LuuBi.jpg" class="profile-img">

                <h3 class="user-name">Bùi Đức Nhân</h3>
                <h5>Managing Partner</h5>
                <p>Friendly members, Team Leader</p>
            </div>
            <div class="profile">
                <img src="image/TruongPhi.jpg" class="profile-img">

                <h3 class="user-name">Bùi Hữu Luận</h3>
                <h5>Project Manager</h5>
                <p>Strategic, Future orientationing</p>
            </div>
            
        </div>
    </div>
    </section>
    <!-- Members ends-->

    <section id="exercises">
        <div class="exercises_container">
            <!--
            <div class="exercises">
                <h1>TestApp</h1><br>
                <a href="testApp.jsp">CLICK</a>
            </div>
            -->
            <div class="exercises">
                <h1>Email lists - Survey</h1><br>
                <a href="exercise.jsp">CLICK</a>
            </div>
            <div class="exercises">
                <h1>Music download - cookie</h1><br>
                <a href="album_list.jsp">CLICK</a>
            </div>
            <div class="exercises">
                <h1>Music cart</h1><br>
                <a href="loadProducts">CLICK</a>
            </div>
            <div class="exercises">
                <h1>EL convert</h1><br>
                <a href="ELindex.jsp">CLICK</a>
            </div>
            <div class="exercises">
                <h1>SQL Gate Way</h1>
                <a href="sqlGateway.jsp">CLICK</a>
            </div>
            <div class="exercises">
                <h1>JPA</h1>
                <a href="emaillist_JPA.jsp">CLICK</a>
            </div>
        </div>
    </section>

  </body>
</html>
