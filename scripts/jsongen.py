import os
import tkinter as tk
from tkinter import messagebox, simpledialog, filedialog
import json
import re
import pyperclip

class BeverageGeneratorApp:
    def __init__(self, root):
        self.root = root
        root.geometry("300x400")
        root.title("Генератор JSON напитка")

        # Инициализация переменных
        self.initialize_variables()

        # Создание интерфейса
        self.initialize_interface()

        # Настройка пути по умолчанию
        self.setup_default_save_directory()

        # Привязка обновления имени файла к изменению ID напитка
        self.id_var.trace_add("write", self.update_filename_from_id)

    def initialize_variables(self):
        """Initializes variables."""
        self.id_var = tk.StringVar()
        self.potency_var = tk.IntVar()
        self.durationSeconds_var = tk.IntVar()
        self.nutrition_var = tk.IntVar()
        self.saturation_var = tk.IntVar()
        self.effects = []
        self.save_path = ""
        self.use_id_in_filename = tk.BooleanVar(value=True)

    def initialize_interface(self):
        """Initializes grid and creates interface elements."""
        self.configure_grid()
        self.create_input_fields()
        self.create_effect_controls()
        self.create_save_controls()
        self.toggle_filename_color()

    def configure_grid(self):
        """Grid setup."""
        MAX_ROWS = 13
        for row in range(MAX_ROWS):
            self.root.grid_rowconfigure(row, weight=1)
        self.root.grid_columnconfigure(0, weight=1)
        self.root.grid_columnconfigure(1, weight=3)

    def create_input_fields(self):
        """Creates input fields."""
        self.add_labeled_entry("ID напитка", self.id_var, 0)
        self.add_labeled_entry("Уровень опьянения", self.potency_var, 1)
        self.add_labeled_entry("Длительность опьянения, секунды", self.durationSeconds_var, 2)
        self.add_labeled_entry("Уровень еды", self.nutrition_var, 3)
        self.add_labeled_entry("Модификатор насыщения", self.saturation_var, 4)

    def add_labeled_entry(self, label_text, variable, row):
        """Creates label with input field."""
        tk.Label(self.root, text=label_text).grid(row=row, column=0, sticky="nsew")
        tk.Entry(self.root, textvariable=variable).grid(row=row, column=1, sticky="nsew")

    def create_effect_controls(self):
        """Creates 'Add effect' button and list of added effects."""
        tk.Button(self.root, text="Добавить эффект", command=self.add_effect).grid(row=6, column=0, columnspan=2, sticky="nsew")
        self.effect_listbox = tk.Listbox(self.root, width=40, height=5)
        self.effect_listbox.grid(row=7, column=0, columnspan=2, sticky="nsew")

    def create_save_controls(self):
        """Creates UI elements associated with file management."""
        tk.Checkbutton(self.root, text="Использовать ID в имени файла", variable=self.use_id_in_filename, command=self.toggle_filename_color).grid(row=8, column=0, columnspan=2, sticky="nsew")
        self.path_label = tk.Label(self.root, text="Текущий путь: не выбран")
        self.path_label.grid(row=9, column=0, columnspan=2, sticky="nsew")
        self.filename_label = tk.Label(self.root, text="Название файла: не задано")
        self.filename_label.grid(row=10, column=0, columnspan=2, sticky="nsew")
        tk.Button(self.root, text="Выбрать путь для сохранения", command=self.select_save_path).grid(row=11, column=0, columnspan=2, sticky="nsew")
        tk.Button(self.root, text="Предпросмотр JSON", command=self.preview_json).grid(row=12, column=0, columnspan=2, sticky="nsew")
        tk.Button(self.root, text="Копировать JSON", command=self.copy_to_clipboard).grid(row=13, column=0, columnspan=2, sticky="nsew")
        tk.Button(self.root, text="Сохранить JSON", command=self.save_to_json).grid(row=14, column=0, columnspan=2, sticky="nsew")

    def setup_default_save_directory(self):
        """Initializes default parameters for file management elements."""
        self.save_directory = os.path.join(os.getcwd(), "beverages")
        os.makedirs(self.save_directory, exist_ok=True)
        self.path_label.config(text=f"Текущий путь: {self.save_directory}")

    def add_effect(self):
        """Open multiple simple dialogs in a sequence to gather data for a new effect entry."""
        effect_type = simpledialog.askstring("Введите тип эффекта", "Например, minecraft:strength")
        if effect_type:
            amplifier = self.validate_positive_integer(
                simpledialog.askinteger("Введите уровень эффекта", "Уровень эффекта"),
                "Уровень"
            )
            durationTicks = self.validate_positive_integer(
                simpledialog.askinteger("Введите длительность", "Длительность эффекта в секундах"),
                "Длительность"
            )
            if durationTicks is not None and amplifier is not None:
                self.effects.append({"type": effect_type, "durationTicks": durationTicks * 20, "amplifier": amplifier})
                self.update_effect_list()

    def validate_positive_integer(self, value, field_name):
        """Checks if given string is a positive integer. If not, displays an error message."""
        if value is None or value < 0:
            messagebox.showerror("Ошибка ввода", f"{field_name} должно быть положительным целым числом.")
            return None
        return value

    def update_effect_list(self):
        """Updates list of effects based on all added effects"""
        self.effect_listbox.delete(0, tk.END)
        for effect in self.effects:
            effect_text = f"{effect['type']} {effect['amplifier']} длительностью: {effect['durationTicks']} тиков"
            self.effect_listbox.insert(tk.END, effect_text)

    def toggle_filename_color(self):
        """Updates filename label text color based on 'Use ID as filename' checkbox. Grey if it's on, black if it's off."""
        color = "gray" if self.use_id_in_filename.get() else "black"
        self.filename_label.config(fg=color)

    def update_filename_from_id(self, *args):
        """Dynamically updates filename label text to the contents of ID input field."""
        if self.use_id_in_filename.get():
            filename = f"{self.id_var.get()}.json" if self.is_valid_filename(self.id_var.get()) else "не задано"
            self.filename_label.config(text=f"Название файла: {filename}")

    def is_valid_filename(self, filename):
        """Checks if given filename is valid."""
        return bool(re.match(r"^[\w\-]+$", filename))

    def select_save_path(self):
        """Opens 'select save path' Windows dialog window."""
        filename = f"{self.id_var.get()}.json" if self.is_valid_filename(self.id_var.get()) else "не задано.json"
        selected_path = filedialog.asksaveasfilename(
            defaultextension=".json",
            filetypes=[("JSON files", "*.json")],
            initialfile=filename,
            initialdir=self.save_directory
        )
        if selected_path:
            self.save_path = selected_path
            directory = os.path.dirname(selected_path)
            self.path_label.config(text=f"Текущий путь: {directory}")
            self.filename_label.config(text=f"Название файла: {os.path.basename(selected_path)}")
            messagebox.showinfo("Путь выбран", f"Файл будет сохранен в: {selected_path}")

    def preview_json(self):
        """Opens JSON preview window."""
        beverage_data = self.collect_beverage_data()
        preview = json.dumps(beverage_data, indent=4, ensure_ascii=False)
        messagebox.showinfo("Предварительный просмотр JSON", preview)

    def collect_beverage_data(self):
        """Returns data from every input field."""
        return {
            "id": self.id_var.get(),
            "potency": self.potency_var.get(),
            "durationSeconds": self.durationSeconds_var.get(),
            "nutrition": self.nutrition_var.get(),
            "saturation": str(self.saturation_var.get() * 0.1) + "F",
            "effects": self.effects
        }

    def save_to_json(self):
        """Exports text from input fields as JSON file. If access is blocked or save failed, displays an error message."""
        if not self.save_path:
            self.save_path = os.path.join(self.save_directory, f"{self.id_var.get()}.json")
        
        if not os.access(os.path.dirname(self.save_path), os.W_OK):
            messagebox.showerror("Ошибка пути", "Путь недоступен для записи.")
            return

        beverage_data = self.collect_beverage_data()

        try:
            with open(self.save_path, "w", encoding="utf-8") as file:
                json.dump(beverage_data, file, indent=4, ensure_ascii=False)
            messagebox.showinfo("Успех", f"Файл успешно сохранен в {self.save_path}.")
        except Exception as e:
            messagebox.showerror("Ошибка", f"Не удалось сохранить файл: {e}")

    def copy_to_clipboard(self):
        """Copies JSON to clipboard."""
        beverage_data = self.collect_beverage_data()
        json_text = json.dumps(beverage_data, indent=4, ensure_ascii=False)
        pyperclip.copy(json_text)
        messagebox.showinfo("Скопировано", "JSON скопирован в буфер обмена.")

def main():
    root = tk.Tk()
    app = BeverageGeneratorApp(root)
    root.mainloop()

if __name__ == "__main__":
    main()
