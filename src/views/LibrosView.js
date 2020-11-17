import React, { useState, useEffect } from "react";
import { Container,Row,Col,CardDeck } from "react-bootstrap";
import LibroService from "../services/LibroService";
import CardLibro from '../components/CardLibro'
const LibrosView = () => {
    const [libros, setLibro] = useState(null);
   useEffect(() => {
     handleGetLibro();
   }, []);
   const handleGetLibro = async () => {
     try {
       const resp = await LibroService.get();
       console.log(resp);
       console.log(resp.data);
       setLibro(resp.data);
     } catch (error) {
       console.log(error);
     }
   }; 
   const handledRenderLibros=()=>{
       if(!libros || libros.length ===0){
           return <div>No existen datos</div>
       }
       const columns = 4;
       let rows = Math.floor(libros.length/columns);
       const resto = libros.length % columns ;
       console.log(resto)
       if (resto !== 0){
           rows = rows+1;
       }
       console.log(rows)
       const arrayRows = [...Array(rows)]
       return arrayRows.map((row, index)=>{
           return (
               <CardDeck>{
                   libros.slice(
                       index === 0 ? index:index*columns,
                       index ===0 ? columns : index*columns+columns
                   ).map((libro,index)=>{
                       return <CardLibro key={index}
                                        id_libro={libro.id_libro}
                                        nombre={libro.nombre}
                                        autor={libro.autor}
                                        anio_publicacion={libro.anio_publicacion}
                                        cant_paginas={libro.cant_paginas
                                        }/>
                   })
               }
               </CardDeck>
           );
       })
   }
   return (
    <Container>
        {handledRenderLibros()}
    </Container>
   );
  /*  return (
    <div className="container">
       <div><ul>{ libros && libros.map((libro, index)=>{ 
      return <li>{libro.id},{libro.nombre},{libro.autor},{libro.publicacion},{libro.paginas}</li>
      }) 
    }</ul></div> 
    </div>
   ); */
};
export default LibrosView;