 <?php 
ob_start();
session_start();
?>
 
 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
</head>
<body>

	<?php
	/*
	if(!empty($_SESSION)){
		header("refresh: 3; url=ci.php");
		echo 'User has been signed in. Redirecting to portal...;';
		die();
	}
	*/
	$url = "http://localhost:8080/QuanLyGiaiDau/rest/services/get-team/";
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_POST, 1);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 0);
	curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
	$data = curl_exec($ch);
	curl_close($ch);
	$jsonData = json_encode($data);
	echo $jsonData;


	?>
    
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="GET">
        <input type="submit" value="Retrive" />
    </form>
</body>
</html>