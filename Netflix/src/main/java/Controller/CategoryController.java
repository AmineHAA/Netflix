package Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Category;
import Model.User;
import Repository.CategoryRepository;
import Repository.UserRepository;

public class CategoryController {
	
	
	@Autowired
	private CategoryRepository CategoryRepository;
	
	
	@GetMapping("/create")
	public String createUserForm(Model model) {
		model.addAttribute("User", new User());
		return "create";
	}
	
	@PostMapping("/createCat")
	public String createCat(@Valid Category Category, BindingResult bindingResult) {

		if(bindingResult.hasErrors())
			return "create";
		
		Category sauvegardeCat = CategoryRepository.save(Category);
		
		
		System.out.println("nouvelle Categorie enregistre avec identifiant : "+sauvegardeCat.getId());
		return "redirect:/";
	}

	@GetMapping("/Category/{id}")
	public Category CategoryByName(@PathVariable(value="id") int id){
		return CategoryRepository.findById(id);
	}
	
	@GetMapping("Category/delete/{id}")
	public String deleteCategory(@PathVariable("id") Long id){
		CategoryRepository.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("Category/edit/{id}")
	public String editCategoryForm(@PathVariable("id") Long id, Model model){
		
		Category Cat = CategoryRepository.findOne(id);
		model.addAttribute("Category", Cat);
		
		return "edit";
	}
	
	@PostMapping("Category/edit")
	public String editCategory(@Valid Category Cat){
		CategoryRepository.save(Cat);		
		return "redirect:/";
	}
	
	 

}
