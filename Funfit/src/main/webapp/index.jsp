<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FunFit</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #74ebd5, #9face6);
            background-size: cover;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Poppins', sans-serif;
            text-align: center;
            color: #fff;
        }

        #welcomeContainer {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 40px 60px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
        }

        h1 {
            font-size: 2.5rem;
            margin-bottom: 20px;
            font-weight: bold;
            color: #fff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        p {
            font-size: 1rem;
            margin-bottom: 30px;
            color: black;
        }

        #startButton {
            background-color: #1abc9c;
            color: #fff;
            padding: 12px 30px;
            font-size: 18px;
            font-weight: bold;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
            text-transform: uppercase;
        }

        #startButton:hover {
            background-color: #16a085;
            transform: scale(1.05);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>

<body>
    <div id="welcomeContainer">
        <h1>Welcome to FunFit</h1>
        <p>Your personalized Zumba management system. Ready to get started?</p>
        <button id="startButton" onclick="openWelcomePage()">Let's Get Started</button>
    </div>

    <script>
        function openWelcomePage() {
            window.location.href = "Welcome.html";
        }
    </script>
</body>

</html>
