<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>


<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				테스트
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="contents" id="summernote"></textarea>
				<script>
				      $('#summernote').summernote({
				        placeholder: 'Hello bootstrap 4',
				        tabsize: 2,
				        height: 100
				      });
				</script>
			</td>
		</tr>
	</table>
</body>
</html>