<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../layout/header.jsp"%>
      <link href="https://cdn.jsdelivr.net/npm/tailwindcss/dist/tailwind.min.css" rel="stylesheet"> 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css">
      <div class="w-full md:w-3/5 mx-auto p-8">
         <p>Open <strong>multiple</strong></p>
         <div class="shadow-md">
            <c:forEach var="pub" items="${list }">
         		<div class="tab w-full overflow-hidden border-t">
               		<input class="absolute opacity-0 " id="tab-multi-one" type="checkbox" name="tabs">
               		<label class="block p-5 leading-normal cursor-pointer" for="tab-multi-one">${pub.p_title } ${pub.p_time }</label>
               		<div class="tab-content overflow-hidden border-l-2 bg-gray-100 border-indigo-500 leading-normal">
                  		<p class="p-5">${pub.p_content }</p>
              	 	</div>
             	</div>
         	</c:forEach>       
         </div>
  
      </div>
   </body>
   <script>
      /* Optional Javascript to close the radio button version by clicking it again */
      var myRadios = document.getElementsByName('tabs2');
      var setCheck;
      var x = 0;
      for(x = 0; x < myRadios.length; x++){
          myRadios[x].onclick = function(){
              if(setCheck != this){
                   setCheck = this;
              }else{
                  this.checked = false;
                  setCheck = null;
          }
          };
      }
   </script>
</html>