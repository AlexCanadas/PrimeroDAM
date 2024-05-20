xquery version "3.1";

(: Este es un comentario en XQuery :)
 
for $item in /bookstore/book (: Recorremos todos los books :)
let $anio := $item/year/text() (: Guardamos el contenido de year de cada item en anio :)
where $anio > 2010 and $item/price < 30 (: Condición para filtrar datos :)
return $anio

(: Order by :)
for $item in /bookstore/book 
let $anio := $item/year/text() 
where $anio > 2010 and $item/price < 30 
order by $item/price, $anio (: Ordenamos por precio y si hubiese iguales, ordena por precio :)
return $anio

(: Return :)
for $item in /bookstore/book 
let $anio := $item/year/text() 
where $anio > 2010 and $item/price < 30 
order by $item/price, $anio 
return <li anio="{$anio}">$item/title<li> (: Ordenamos por precio y si hubiese iguales, ordena por precio :)

(: Devuelve contenido de años :)
for $libro in /bookstore/book
let $anio := $libro/year/text()
return $anio

(: Devuelve contenido de años si es mayor a 2009 y el precio menor a 60:)
for $libro in /bookstore/book
let $anio := $libro/year/text()
where $anio > 2009 and $libro/price < 60
return $anio

(: Devuelve contenido de title si es mayor a 2009 y el precio menor a 60, y lo mete en un li :)
for $libro in /bookstore/book
let $anio := $libro/year
where $anio > 2009 and $libro/price < 60
return <li>$libro/title/text()</li>

(: Devuelve li con libros que tengan precio mayor a 30  :)
for $i in //book[price<30]
let $output = "<li>"+$i/@category+"</li>"
return $output
