import React from "react";
import { Card, Button } from "react-bootstrap";
import Book from '../img/book.png'
function CardLibro(props) {
    const {nombre,autor,genero,fecha,paginas,id} = props;
  return (
    <Card className="text-center"  border="dark" style={{ width: '18rem' }} >
      <Card.Img variant="top" src={Book} />
      <Card.Body>
        <Card.Title>{nombre}</Card.Title>
        <Card.Text>
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
      <Button variant="info">Actualizar</Button>
      <Button  variant="danger" onClick={()=>props.handleDeleteLibro(id)}
     >Eliminar</Button>
      </Card.Footer>
    </Card>
    
  );
}
export default CardLibro;