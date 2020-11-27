import React, { useState, useEffect } from "react";
import { Card, Button } from "react-bootstrap";
import Book from '../img/book.png'
import UpdateLibroModal from '../components/UpdateLibroModal';
import LibroService from '../services/LibroService';
import CreateReservaModal from '../components/CreateReservaModal';
import ReservaService from '../services/ReservaService';
import LibrosView from '../views/LibrosView';
import Swal from 'sweetalert2';


function CardLibro(props) {
    const {nombre,autor,genero,fecha,paginas,id} = props;
    const [show, setShow] = useState(false);
    const [showReserva, setShowReserva] = useState(false);

    const handleCloseReserva = () => {
      setShowReserva(false)
  }

  const handleOpenModalReserva = () => {
    setShowReserva(true)
  }

    useEffect(() => {
      console.log('nuevo estado');
  }, [show]);

 const handleSaveReserva = (reserva) => {
    Swal.fire({
       
        icon: 'success',
        text: 'Reserva Exitosa'
    });
    
    ReservaService.create(reserva)
      .then((resp) => {
        Swal.close();
        console.log(resp);
        handleCloseReserva();
    }, (err) => {
        Swal.close();
        console.log(err);
        Swal.fire({
            title: 'Error Fatal',
            icon: 'error',
            text: 'Error realizando la  Reserva'
        });
    })
}



 

    const handleUpdateLibro = async (id,libro) => {      
      const respModal = await Swal.fire({
        title: 'Actualizar Libro',
        icon: 'info',
        text: '¿Esta seguro de que quiere modificar el Libro?, esta acccion no podra revertirse',
        showCancelButton: true,
        confirmButtonText: 'SI',
        cancelButtonText: 'NO'
      });
      if (!respModal.value) {
        return;
    }
    
    LibroService.update(id,libro).then(resp => {
        console.log(resp);
        handleClose();
    }, (err) => {
        console.log('error al actualizar el libro', err);
    });
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
      
        <strong>ID: </strong> {id}
        <br/>
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
      
   <Button  className="buttonCrud" variant="primary" onClick={handleOpenModalReserva} >Reservar</Button>                    
  {
    showReserva && 
    <CreateReservaModal
    showReserva={showReserva}
    handleCloseReserva={handleCloseReserva}
    handleSaveReserva={handleSaveReserva}
    />
  }
  <p></p>
      <Button className="buttonCrud" variant="dark" 
      onClick={handleOpenModal}>Actualizar</Button><p></p>
   {
                show &&
                <UpdateLibroModal
                    show={show}
                    handleClose={handleClose} 
                    handleUpdateLibro={handleUpdateLibro}
                    data={props}
                    />
            }
      <Button className="buttonCrud" variant="danger" 
      onClick={()=>props.handleDeleteLibro(id)}>Eliminar</Button>
      </Card.Footer>
    </Card>
    
  );
}
export default CardLibro;