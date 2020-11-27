import React, { useState, useEffect } from "react";
import { Button, Container } from "react-bootstrap";
import CreateLibroModal from '../components/CreateLibroModal';
import CreateReservaModal from '../components/CreateReservaModal';
import LibroService from '../services/LibroService';
import ReservaService from '../services/ReservaService';

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

    const handleSaveLibro = async (libro) => {
        const respModal = await Swal.fire({
            title: 'Publicar Libro',
            icon: 'info',
            text: '¿Esta seguro de que quiere publicar un nuevo Libro?, esta acccion no podra revertirse',
            showCancelButton: true,
            confirmButtonText: 'SI',
            cancelButtonText: 'NO'
          });
          if (!respModal.value) {
            return;
        }
        
        LibroService.create(libro).then(resp => {
            console.log(resp);
            handleClose();
        }, (err) => {
            console.log('error al publicar el libro', err);
        });
        }
        


    

    return (
        
        <Container>
            <p></p>
            <Button className="button" onClick={handleOpenModal} variant="dark"><h5>AGREGAR LIBRO</h5></Button>
            {
                show &&
                <CreateLibroModal
                    show={show}
                    handleClose={handleClose}
                    handleSaveLibro={handleSaveLibro} />
            }
            <p></p>
           </Container>
    );
}

export default AgregarLibroView;
