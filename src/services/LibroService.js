import { AxiosInstance } from "../config/axios-config"

class LibroService {
    get() {
        return AxiosInstance.get("libro");
    }
}

export default new LibroService();