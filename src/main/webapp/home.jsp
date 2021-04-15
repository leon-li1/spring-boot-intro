<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    </head>
    <body>
        <h2> Add Alien </h2>
        <form action="addAlien">
            <input type="text" name="aid"><br>
            <input type="text" name="aname"><br>
            <input type="submit"><br>
        </form>
        <h2> Get Alien </h2>
        <form action="getAlien">
            <input type="text" name="aid"><br>
            <input type="submit"><br>
        </form>
        <h2> Update Alien </h2>
        <form action="updateAlien">
            <input type="text" name="aid"><br>
            <input type="text" name="aname"><br>
            <input type="submit"><br>
        </form>
        <h2> Delete Alien </h2>
        <form action="deleteAlien">
            <input type="text" name="aid"><br>
            <input type="submit"><br>
        </form>
        </br>
        <a href="/aliens" class="button">Get Aliens</a>
    </body>
</html>