<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test</title>
</head>
<style>
    * {
        background-color: black;
    }

    h1 {
        color: white;
        font-size: larger;
        text-align: center;
        font-family: "JetBrains Mono", sans-serif;
    }

    p {
        color: white;
        text-align: left;
        font-family: "JetBrains Mono", sans-serif;
    }
    a{
        color: white;
        text-align: left;
        font-family: "JetBrains Mono", sans-serif;
    }
</style>
<body>
<h1>
    Hello ${username} how are you?
</h1>
<p> ${username} I am developer at Google</p>
<a href="http://localhost:8080/api/login?token=${token}">Token</a>

</body>
</html>