<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Membership Page</title>
        <link rel="stylesheet" href="./styles/membership.css">
    </head>
    <body>
        <div class="background">
            <video class="back-video" autoplay muted loop>
                <source src="./assets/videos/HomeBG.mp4" type="video/mp4">
            </video>
            <div class="overlay"></div>
        </div>
        <header>
            <div class="container">
                <div class="logo">
                    <img src="./assets/images/logo/logo.png" alt="Site Logo">
                </div>
                <nav>
                    <ul>
                        <li class="menu-item"><a href="homepage">Home</a></li>
                        <li class="menu-item dropdown">
                            <a href="#">Western</a>
                            <ul class="dropdown-menu">
                                <li><a href="westernfeature1">Western Feature 1</a></li>
                                <li><a href="westernfeature2">Western Feature 2</a></li>
                            </ul>
                        </li>
                        <li class="menu-item dropdown">
                            <a href="#">Eastern</a>
                            <ul class="dropdown-menu">
                                <li><a href="eastern-feature-1">Eastern Feature 1</a></li>
                                <li><a href="eastern-horoscope">Eastern Feature 2</a></li>
                            </ul>
                        </li>
                        <li class="menu-item"><a href="#">Articles</a></li>
                        <li class="menu-item"><a href="#">Membership</a></li>
                    </ul>
                </nav>
                <div class="auth-buttons">
                    <button class="login-button">Sign Out</button>
                </div>
            </div>
        </header>

        <main class="container">
            <form action="membership" method="post">
                <div class="main-container">
                    <div class="content-box">
                        <h1>VIP MEMBERSHIP</h1>
                        <p>Become a lifetime member and enjoy VIP member privileges. One and forever.</p>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            <span class="icon-overlay"></span>
                            Unlock the Eastern horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Draw Card feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Western horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Weak Element feature
                        </h2>
                        <h1>
                            <br>
                            Only 19.99 $
                        </h1>
                        <button type="submit" name="membership" value="vip" class="register-button">Get A Plan</button>

                        <c:choose>
                            <c:when test="${not empty requestScope.msgVip}">
                                <h3 style="display: block;">${requestScope.msgVip}</h3>
                            </c:when>
                            <c:otherwise>
                                <h3 style="display: none;">${requestScope.msgVip}</h3>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="content-box">
                        <h1>VIP++ MEMBERSHIP</h1>
                        <p>Become a lifetime member and enjoy VIP++ member privileges. One and forever.</p>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Eastern horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Draw Card feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Western horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Weak Element feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Chat One-on-One with our mentors
                        </h2>
                        <h1>
                            <br>
                            Only 39.99 $
                        </h1>
                        <button type="submit" name="membership" value="vip++" class="register-button">Get B Plan</button>

                        <c:choose>
                            <c:when test="${not empty requestScope.msgVipPlus}">
                                <h3 style="display: block;">${requestScope.msgVipPlus}</h3>
                            </c:when>
                            <c:otherwise>
                                <h3 style="display: none;">${requestScope.msgVipPlus}</h3>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form>
        </main>

        <footer>
            <div class="container">
                <div class="footer-content">
                    <div class="footer-left">
                        <img src="./assets/images/logo/logo.png" alt="Company Logo" class="footer-logo">
                        <p>Site Generator is a set of useful templates with fresh layouts.</p>
                    </div>
                    <div class="footer-right">
                        <div class="footer-section">
                            <h4>Download</h4>
                            <ul>
                                <li><a href="#">Windows app</a></li>
                                <li><a href="#">Mac app</a></li>
                                <li><a href="#">Linux app</a></li>
                                <li><a href="#">Desktop app</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Products</h4>
                            <ul>
                                <li><a href="#">Web</a></li>
                                <li><a href="#">App</a></li>
                                <li><a href="#">Software</a></li>
                                <li><a href="#">Ecommerce</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Services</h4>
                            <ul>
                                <li><a href="#">Design</a></li>
                                <li><a href="#">Development</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Company</h4>
                            <ul>
                                <li><a href="#">Terms & conditions</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Get in touch</h4>
                            <ul class="social-media">
                                <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                            </ul>
                            <div class="subscribe-form">
                                <input type="email" placeholder="Enter email address">
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script src="scripts/membership.js"></script>
    </body>
</html>
