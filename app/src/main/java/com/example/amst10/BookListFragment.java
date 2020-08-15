package com.example.amst10;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookListFragment extends Fragment {
    private  Activity activity;
    public static ArrayList<Book> items=new ArrayList<>();



    public BookListFragment(Activity activity){
       super();
        this.activity=activity;
    }
    public BookListFragment(){
        super();
    }
    public static  void  addBooks(){
        items.add(new Book("https://static.megustaleer.com/images/libros_650_x/P32147B.jpg"," Ray Bradbury"," Ballantine Books"," Fahrenheit 451","Guy Montag es un bombero y el trabajo de un bombero es quemar libros, que están prohibidos porque son causa de discordia y sufrimiento.","Ciencia Ficcion"));
        items.add(new Book("https://miro.medium.com/max/3412/1*vcN21-CZGrj5dwozpqS2lg.jpeg"," George Orwell"," Arenal"," 1984","Londres está controlada por un gobieno totalitario. El Gran Hermano lo vigila absolutamente todo. ","Ciencia Ficcion"));
        items.add(new Book("https://lapiedradesisifo.com/wp-content/uploads/2019/11/NV47628.jpg"," Frank Herbert"," Chilton Company"," Dune","Arrakis: un planeta desértico donde el agua es el bien más preciado y, donde llorar a los muertos es el símbolo de máxima prodigalidad.","Ciencia Ficcion"));
        items.add(new Book("https://images-na.ssl-images-amazon.com/images/I/81fNzN2rqXL.jpg"," Walter M. Miller Jr."," J. B. Lippincott & Co."," Cántico por Leibowitz","Leibowitz es una congregación fundada por un técnico tras el Diluvio de Fuego (la guerra nuclear).","Ciencia Ficcion"));
        items.add(new Book("https://images-na.ssl-images-amazon.com/images/I/81c8No6mSPL.jpg"," Stephen King"," Doubleday"," The Stand","The Stand cuenta la historia de los sobrevivientes de un mundo diezmado por una epidemia incurable","Terror/Horror"));
        items.add(new Book("https://images-na.ssl-images-amazon.com/images/I/71CM7BMb01L.jpg"," Rivers Solomon"," Simon and Schuster"," La profundidad","La historia de un pescador islandés que se convirtió en un héroe nacional y en un objeto de estudio científico.","Terror/Horror"));
        items.add(new Book("https://images-na.ssl-images-amazon.com/images/I/71Hs7T-1TVL.jpg"," H. P. Lovecraft"," Weird Tales"," El horror de Dumwich","Wilbur Whateley, hijo precoz y monstruoso de una solitaria familia de Dunwich, conserva parte del atroz secreto del Necronomicón, el libro prohibido. ","Terror/Horror"));
        items.add(new Book("https://www.libreriasinopsis.com/imagenes/9788415/978841561883.JPG"," Bram Stoker"," Robinson"," Dracula","Cuando Jonathan Harker viajó a Transilvania por asuntos de negocios, nunca imaginó el peligro que corría.","Terror/Horror"));
        items.add(new Book("https://static.megustaleer.com/images/libros_200_x/9786073160056.jpg"," Laura Esquivel"," Mondadori","Como agua para chocolate"," Tita tiene el don de traspasarle a sus platos lo que siente a la hora de cocinarlos.","Romance/Drama"));
        items.add(new Book("https://covers.alibrate.com/b/59872eaecba2bce50c1f0f62/254d8fa9-0e76-4c81-b2d8-c61933efab16/share"," Jane Austen"," Thomas Egerton"," Orgullo y Prejuicio","Jane Austen nos habla, a través de la adorable Elizabeth Bennet, sobre la importancia de escuchar nuestro propio deseo.","Romance/Drama"));
        items.add(new Book("https://www.anagrama-ed.es/uploads/media/portadas/0001/18/0a44b41b7aaab8078dc1b053ec06aac4e5549bb5.jpeg"," Kazuo Ishiguro","Faber and Faber"," Nunca me abandones","Hailsham es una mezcla de internado victoriano y de colegio para hijos de hippies de los años sesenta.","Romance/Drama"));
        items.add(new Book("https://images-na.ssl-images-amazon.com/images/I/41GXI7p%2BRUL._AC_SY400_.jpg"," Haruki Murakami"," Kodansha"," Al sur de la frontera, al oeste del sol","Al crecer en los suburbios del Japón de la posguerra, a Hajime le parecía que todos menos él tenían hermanos y hermanas.","Romance/Drama"));
        items.add(new Book("https://m.media-amazon.com/images/I/51EfpBtirjL.jpg"," Daniel Defoe"," Paternoster"," Robinson Crusoe","Narra las aventuras del joven Robinson Crusoe, un náufrago inglés que pasa 28 años en una remota isla tropical.","Aventura"));
        items.add(new Book("https://www.alianzaeditorial.es/imagenes/libros/grande/9788491049616-moby-dick.jpg"," Herman Melville"," Alianza"," Moby Dick","La lucha del hombre contra la bestia, contra el mal y contra el destino: eso es lo que el capitán Ahab busca al perseguir a Moby Dick.","Aventura"));
        items.add(new Book("https://www.ecured.cu/images/thumb/e/e7/Aventuras_de_Tom_Sawyer.jpg/260px-Aventuras_de_Tom_Sawyer.jpg"," Mark Twain","Edinun"," Las aventuras de Tom Sawyer","Es el relato de un niño que vive en una ciudad pequeña del suroeste de Estados Unidos a orillas del Mississippi.","Aventura"));
        items.add(new Book("https://contentv2.tap-commerce.com/cover/large/9788494733154_1.jpg?id_com=1113"," Julio Verne"," Eneida"," El faro del fin del mundo","La misión pacífica encomendada a los fareros Vázquez y Felipe en una isla aparentemente deshabitada, va a trastornarse en un encuentro violento.","Aventura"));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;

        View v= inflater.inflate(R.layout.fragment_list,container,false);
       final BookAdapter adapter=new BookAdapter(getContext(),items,activity);//items es el arrayList


        SearchView sv=v.findViewById(R.id.searchBooks);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });
        recyclerView=v.findViewById(R.id.listBooksC);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return v;

    }
}
