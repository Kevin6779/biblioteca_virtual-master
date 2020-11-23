import React, { useState, useEffect } from "react";
import { Card, Button } from "react-bootstrap";
import Book from '../img/book.png'
import UpdateLibroModal from '../components/UpdateLibroModal';
import LibroService from '../services/LibroService';
import Swal from 'sweetalert2';


function CardLibro(props) {
    const {nombre,autor,genero,fecha,paginas,id} = props;
    const [show, setShow] = useState(false);

    useEffect(() => {
      console.log('nuevo estado');
      console.log(id);
  }, [show]);

   /* function update (id){
      console.log(id);
    }*/

    const handleUpdateLibro = (id) => {
      Swal.fire({
         
          icon: 'success',
          text: 'Libro Actualizado'
      });
      
      LibroService.update(id)
        .then((resp) => {
          Swal.close();
          console.log(resp);
          handleClose();
      }, (err) => {
          Swal.close();
          console.log(err);
          Swal.fire({
              title: 'Error',
              icon: 'error',
              text: 'Error    '
          });
      })
  }

    const handleClose = () => {
      setShow(false)
  }

  const handleOpenModal = () => {
      setShow(true)
  }

  return (
    <Card className="text-center"  border="dark" style={{ width: '18rem' }} >
      <Card.Img variant="top" src={Book} />
      <Card.Body>
        <Card.Title>{nombre}</Card.Title>
        <Card.Text>
          <strong>ID: </strong>{id}
          <p></p>
          <strong>Autor: </strong>{autor}
          <br/>
          <strong>Genero: </strong>{genero}
          <br/>
          <strong>Publicación: </strong>{fecha}
          <br/>
          <strong>Paginas: </strong>{paginas}
        </Card.Text>
      </Card.Body>
      <Card.Footer className="text-muted">
      <Button  variant="dark" onClick={handleOpenModal}  /*onClick={()=>update(id)}*/
     >Actualizar</Button>
       {
                show &&
                <UpdateLibroModal
                    show={show}
                    handleClose={handleClose} 
                    handleUpdateLibro={handleUpdateLibro}/>
            }
      <Button  variant="danger" onClick={()=>props.handleDeleteLibro(id)}
     >Eliminar</Button>
      </Card.Footer>
    </Card>
    
  );
}
export default CardLibro;