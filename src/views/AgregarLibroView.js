import React, { useState, useEffect } from "react";
import { Button, Container } from "react-bootstrap";
import CreateLibroModal from '../components/CreateLibroModal';
import LibroService from '../services/LibroService';
import Swal from 'sweetalert2';

function AgregarLibroView() {
    const [show, setShow] = useState(false);

    useEffect(() => {
        console.log('nuevo estado');
    }, [show]);

    const handleClose = () => {
        setShow(false)
    }

    const handleOpenModal = () => {
        setShow(true)
    }

    const handleSaveLibro = (libro) => {
        Swal.fire({
           
            icon: 'success',
            text: 'Libro Guardado'
        });
        
        LibroService.create(libro)
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

    return (
        <Container>
            <Button onClick={handleOpenModal} variant="primary">Agregar Libro</Button>
            {
                show &&
                <CreateLibroModal
                    show={show}
                    handleClose={handleClose}
                    handleSaveLibro={handleSaveLibro} />
            }
        </Container>
    );
}

export default AgregarLibroView;
