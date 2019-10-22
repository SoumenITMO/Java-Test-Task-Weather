<html>
<head>
    <title>Timezone Lookup by ZIP code</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div style="position: relative; width: 240px; top: 100px; left: 200px;">
        <h5> Enter ZIP code to display timezone and other information </h5>
        <form action="tzone" method="post">
            <div class="form-group">
                <label for="zipcode">ZIP Code</label>
                <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="Enter ZIP code">
            </div>
            <button type="submit" class="btn btn-primary">Lookup</button>
        </form>
    </div>
</body>
</html>
