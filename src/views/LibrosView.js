import React, { useState, useEffect } from "react";
import { Container, Row, Col, CardDeck, Card, Image, Navbar} from "react-bootstrap";
import LibroService from "../services/LibroService";
import CardLibro from "../components/CardLibro";
import Swal from 'sweetalert2';
import twitter from '../assets/Imagenes/twitter.jpg';
import facebook from '../assets/Imagenes/facebook.jpg';
import googlePlus from '../assets/Imagenes/googlePlus.jpg';

const LibrosView = () => {
  const [libros, setLibro] = useState(null);

  useEffect(() => {
    handleGetLibro();
  }, []);
  
  const handleGetLibro = async () => {
    try {
      Swal.fire({
        allowOutsideClick: false,
        icon: 'info',
        text: 'Por favor espere...'
    });

    Swal.showLoading();

      const resp = await LibroService.get();
      console.log(resp);
      console.log(resp.data);
      setLibro(resp.data);

      Swal.close();
    } catch (error) {
      Swal.close();
      console.log(error);
    }
  };
  
    
    
  const handleDeleteLibro = async (id) => {
    const respModal = await Swal.fire({
      title: 'Borrar Libro',
      icon: 'info',
      text: '¿Seguro de que quiere eliminar el Libro?, esta acccion no podra revertirse',
      showCancelButton: true,
      confirmButtonText: 'SI',
      cancelButtonText: 'NO'
    });

    if (!respModal.value) {
      return;
  }

  LibroService.delete(id).then(resp => {
      console.log(resp);
      handleGetLibro();
  }, (err) => {
      console.log('error al eliminar libro', err);
  });
}
  
  const handledRenderLibros = () => {
    if (!libros || libros.length === 0) {
      return <div></div>;
    }
    const columns = 4;
    let rows = Math.floor(libros.length / columns);
    const resto = libros.length % columns;
    console.log(resto);
    if (resto !== 0) {
      rows = rows + 1;
    }
    console.log(rows);
    const arrayRows = [...Array(rows)];
    return arrayRows.map((row, index) => {
   
      
  

      return (

       
        <Card className="card1" border="dark"><h5 className="text-center"><br></br>LIBROS DISPONIBLES</h5>
        <Card.Body>
        <p> 
                            
        <CardDeck key={index}>
         
          {libros 
            .slice(
              index === 0 ? index : index * columns,              
              index === 0 ? columns : index * columns + columns
            )
            .map((libro, index) => {
              return (
                <CardLibro
                  key={index}
                  id={libro.id}
                  nombre={libro.nombre}
                  autor={libro.autor}
                  genero={libro.genero.nombre}
                  fecha={libro.publicacion}
                  paginas={libro.paginas}
                  disponibilidad={libro.disponibilidad}
                  handleDeleteLibro={handleDeleteLibro}
                  
                />
              );
            })}
        </CardDeck></p></Card.Body></Card>
      );
    });
  };
  return <Container>{handledRenderLibros()} 
    <Card className="footer">
  <Card.Body><h4>Siguenos en nuestras redes sociales</h4>
  <p></p>
  
   <Navbar.Brand href="https://twitter.com/"className="custom-link">
  <Image src={twitter} />
  </Navbar.Brand>
  <Navbar.Brand href="https://www.facebook.com/"className="custom-link"> 
  <Image src={facebook} />
  </Navbar.Brand>
 
  <Navbar.Brand href="https://www.google.com/search?q=google+plus&hl=es&tbm=isch&source=iu&ictx=1&fir=Dc9etFG0K1EonM%252C9onwM-we8RMatM%252C%252Fm%252F0gh6xtp&vet=1&usg=AI4_-kTp5lxpozVGZ6AgNebugzAm4WhJNQ&sa=X&ved=2ahUKEwjiv8bWsaTtAhVOjlkKHUyGAGcQ_B16BAgrEAI&biw=1366&bih=657#imgrc=Dc9etFG0K1EonM"className="custom-link">
  <Image src={googlePlus} />
  </Navbar.Brand>        
  </Card.Body>
</Card>
</Container>;
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
