<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Paulina's Weather App</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<!-------------------------------------------------------- NAVBAR------------------------------------------_------------------------->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Weather App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <ul>
            <form class="form-inline my-2 my-lg-0" style="display: flex; justify-content: center; flex-direction: row">
                <input class="form-control mr-sm-2" type="search" placeholder="City" style="margin: 5px 10px 0px 100px;length: 200px;" aria-label="Weather for city">
                <button class="btn btn-outline-primary my-sm-0" style="margin: 5px 10px 0px 0px" type="submit">Search</button>
            </form>
        </ul>
        <ul style="display: flex; justify-content: center; flex-direction: row">
            <img class="logo" src="https://i.postimg.cc/BbL3Hynm/Weather-API.jpg" width="20%" style="margin: 5px 10px 0px 400px; border-radius: 10px;" alt="Logo">
        </ul>
    </div>
</nav>

<!-------------------------------------------------------- HEADER 1------------------------------------------------------------_------->
<h1 style="color: darkred"></h1>
<br/>
<br/>
<!---------------------------------------------- SEVERAL CHOSEN WEATHERS---------------------------------------------------------------->
<!--Chosen Weather-->
<section class="card-result" style="display: flex; justify-content: center;length: 500px;">
    <div class="card" style="width: 18rem;display: flex; justify-content: center;flex-direction: row;">
        <img class="card-img-top-result" src="..." alt="Card image cap">
        <div class="card-body">
            <h5 id="card-title-chosen" class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <button type="button" class="btn btn-primary refresh">Refresh</button>
        </div>
    </div>
</section>
<br/>

<!--Standard Weathers-->
<section class="card-standard" style="margin: 0px 10px 10px 10px">
<div class="card-group">
    <div class="card" style="width: 18rem;">
        <img id="card-img-standard-one" class="card-img-top-standard-one" src="..." alt="Card image cap">
        <div class="card-body">
            <h5 id="card-title-standard-one" class="card-title">Card title</h5>
            <p id="card-desc-standard-one" class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li id="card-temp-standard-one" class="list-group-item">Cras justo odio</li>
            <li id="card-precip-standard-one" class="list-group-item">Dapibus ac facilisis in</li>
            <li id="card-wind-standard-one" class="list-group-item">Vestibulum at eros</li>
            <li id="card-cloud-standard-one" class="list-group-item">Vestibulum at eros</li>
        </ul>
        <div class="card-body">
            <button type="button" class="btn btn-primary refresh">Refresh</button>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img id="card-img-standard-two" class="card-img-top-standard-two" src="..." alt="Card image cap">
        <div class="card-body">
            <h5 id="card-title-standard-two" class="card-title">Card title</h5>
            <p id="card-desc-standard-two" class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li id="card-temp-standard-two" class="list-group-item">Cras justo odio</li>
            <li id="card-precip-standard-two" class="list-group-item">Dapibus ac facilisis in</li>
            <li id="card-wind-standard-two" class="list-group-item">Vestibulum at eros</li>
            <li id="card-cloud-standard-two" class="list-group-item">Vestibulum at eros</li>
        </ul>
        <div class="card-body">
            <button type="button" class="btn btn-primary refresh" length="100px">Refresh</button>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img id="card-img-standard-three" class="card-img-top-standard-three" src="..." alt="Card image cap">
        <div class="card-body">
            <h5 id="card-title-standard-three" class="card-title">Card title</h5>
            <p id="card-desc-standard-three" class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li id="card-temp-standard-three" class="list-group-item">Cras justo odio</li>
            <li id="card-precip-standard-three" class="list-group-item">Dapibus ac facilisis in</li>
            <li id="card-wind-standard-three" class="list-group-item">Vestibulum at eros</li>
            <li id="card-cloud-standard-three" class="list-group-item">Vestibulum at eros</li>
        </ul>
        <div class="card-body">
            <button type="button" class="btn btn-primary refresh">Refresh</button>
        </div>
    </div>
</div>
</section>

<!---------------------------------------------- REFRESH EATHER BUTTONS ---------------------------------------------------------------->

<!--div href="hello-servlet">Click me!</div-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="script.js"></script>
</body>
</html>